package eu.europa.eea.mayors_adapt.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import eu.europa.eea.mayors_adapt.service.ClpSerializer;
import eu.europa.eea.mayors_adapt.service.DataLocalServiceUtil;
import eu.europa.eea.mayors_adapt.service.DataServiceUtil;


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
            DataLocalServiceUtil.clearService();

            DataServiceUtil.clearService();
        }
    }
}
