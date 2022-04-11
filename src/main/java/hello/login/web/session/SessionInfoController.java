package hello.login.web.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
public class SessionInfoController {

    @GetMapping("/session-info")
    public String sessionInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session == null) {
            return "세션이 없습ㄴ디ㅏ";
        }



        //세션 데이터 출력력
       session.getAttributeNames().asIterator()
                .forEachRemaining(name -> log.info("session name={}, value={}", name, session.getAttribute(name)));

        log.info("session Id={}", session.getId());
        log.info("session maxInactiveInterval={}", session.getMaxInactiveInterval()); //세션 비활성화 시키는 시간 간격
//        session.setMaxInactiveInterval(60); 특정 세션 단위로 시간 설정
        log.info("session getCreationTime={}", new Date(session.getCreationTime()));
        log.info("session getLastAccessedTime={}", new Date(session.getLastAccessedTime()));
        log.info("session isNew={}", session.isNew());

        return "세션 출력";
    }
}
