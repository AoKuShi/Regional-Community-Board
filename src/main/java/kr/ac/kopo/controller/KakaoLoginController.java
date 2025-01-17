package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class KakaoLoginController implements Controller {
    private MemberService memberService;

    public KakaoLoginController() {
        this.memberService = new MemberService(); // 회원 관련 서비스
    }

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = request.getParameter("token"); // 카카오 로그인 창에서 받은 토큰
        String reqUrl = "https://kapi.kakao.com/v2/user/me";

        try {
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder responseContent = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                reader.close();

                JSONObject obj = new JSONObject(responseContent.toString());
                long id = obj.getLong("id"); // 카카오 사용자 ID를 받아옴
                JSONObject properties = obj.getJSONObject("properties"); // 프로필 정보
                String nickname = properties.getString("nickname"); // 닉네임 정보
                JSONObject kakaoAccount = obj.getJSONObject("kakao_account");
                String email = kakaoAccount.optString("email", "default@kakao.com"); // 이메일 정보, 기본값 설정

                // DB에서 사용자 조회
                MemberVO member = new MemberVO();
                member.setMemberId(String.valueOf(id)); // 카카오 ID를 사용자 ID로 설정
                member.setPassword("KakaoPWD"); // 비밀번호는 더미 데이터로 설정
                member.setName(nickname); // 카카오에서 받은 닉네임을 이름으로 설정
                member.setEmail(email); // 가져온 이메일을 설정
                member.setArea("서울"); // 기본 지역 설정

                MemberVO foundMember = memberService.login(member);
                if (foundMember == null) {
                    // 사용자가 존재하지 않을 경우, 새로운 사용자 등록
                    memberService.registerMember(member); // 새 사용자를 DB에 등록
                    foundMember = member; // 등록한 멤버 정보를 사용
                }

                // 세션에 사용자 정보 저장
                HttpSession session = request.getSession();
                session.setAttribute("loginMember", foundMember);

                return "redirect:/index.do"; // 로그인 후 리다이렉트할 페이지
            } else {
                System.out.println("카카오 로그인 요청 실패: " + responseCode);
                return "/member/loginForm.do";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/member/loginForm.do";
        }
    }
}
