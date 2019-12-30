package sec.project.config;

import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class AuthorizationLogger { 
    private static final Logger LOG = LoggerFactory.getLogger("security");

    @EventListener
    public void onAuditEvent(AuditApplicationEvent event) {
        AuditEvent auditEvent = event.getAuditEvent();
        LOG.info("typeprincipal={}", auditEvent.getType(), auditEvent.getPrincipal());
    }
}