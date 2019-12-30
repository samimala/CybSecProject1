package sec.project.config;

import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class AuthorizationLogger { 
    private static final Logger logger = LoggerFactory.getLogger("security");

    @EventListener
    public void onAuditEvent(AuditApplicationEvent event) {
        AuditEvent auditEvent = event.getAuditEvent();
        switch (auditEvent.getType()) {
        case "AUTHENTICATION_FAILURE":
            logger.warn("Authentication failed for " + auditEvent.getPrincipal());
            break;
        
        case "AUTHENTICATION_SUCCESS":
            logger.info(auditEvent.getPrincipal() + " logged in");
            break;
        default:
            logger.info(auditEvent.getType() + ": " + auditEvent.getPrincipal());
            break;
        }
    }
}