package hello.login.web.session;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SessionInfoController {

	@GetMapping("/session-info")
	public String sessionInfo(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return "세션이 없습니다";
		}

		//세션 데이터 출력
		session.getAttributeNames().asIterator()
			.forEachRemaining(name-> log.info("session name={}, value={}", name, session.getAttribute(name)));

		log.info("sessionId={}", session.getId());
		log.info("getMaxInactiveInterval={}", session.getMaxInactiveInterval());
		log.info("creationTime={}", new Date(session.getCreationTime()));
		log.info("lastAccessedTime={}", new Date(session.getLastAccessedTime()));
		log.info("isNew={}", session.isNew());

		return "세션 출력";

	}
}
