package nl.wur.alterra.cgi.ace.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import nl.wur.alterra.cgi.ace.service.ClpSerializer;
import nl.wur.alterra.cgi.ace.service.ProjectLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            ProjectLocalServiceUtil.clearService();
        }
    }
}
