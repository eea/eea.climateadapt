package eea.climadapt.ldap;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.directory.Attributes;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

import com.liferay.portal.DuplicateUserEmailAddressException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ldap.LDAPToPortalConverter;
import com.liferay.portal.security.ldap.LDAPUser;
import com.liferay.portal.security.ldap.PortalLDAPImporterImpl;
import com.liferay.portal.security.ldap.PortalLDAPUtil;

/**
 * An extension of {@link PortalLDAPImporterImpl}.
 * The idea is to override some Liferay's LDAP import functions for EEA-specific situations. Examples:
 * - we do not want a {@link DuplicateUserEmailAddressException} thrown, because we allow duplicate e-mails
 * - we want to truncate users' job titles to 100 characters before passing on to Liferay (allows max 100 chars for job title)
 * - etc.
 *
 * @author Jaanus
 *
 */
public class ClimateAdaptLDAPImporterImpl extends PortalLDAPImporterImpl {

    /** Static logger for this class. */
    private static final Log log = LogFactoryUtil.getLog(ClimateAdaptLDAPImporterImpl.class);

    /** Max length of users' job title. */
    private static final int MAX_JOB_TITLE_LENGTH = 100;

    /**
     * Simple constructor, that just calls super();
     */
    public ClimateAdaptLDAPImporterImpl() {

        super();
        System.out.println("Constructing " + ClimateAdaptLDAPImporterImpl.class.getName() + " ...");
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importFromLDAP()
     */
    @Override
    public void importFromLDAP() throws Exception {
        super.importFromLDAP();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importFromLDAP(long)
     */
    @Override
    public void importFromLDAP(long companyId) throws Exception {
        super.importFromLDAP(companyId);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importFromLDAP(long, long)
     */
    @Override
    public void importFromLDAP(long ldapServerId, long companyId) throws Exception {
        super.importFromLDAP(ldapServerId, companyId);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importLDAPUser(long, long, javax.naming.ldap.LdapContext,
     * javax.naming.directory.Attributes, java.lang.String)
     */
    @Override
    public User importLDAPUser(long ldapServerId, long companyId, LdapContext ldapContext, Attributes attributes, String password)
            throws Exception {
        return super.importLDAPUser(ldapServerId, companyId, ldapContext, attributes, password);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importLDAPUserByScreenName(long, java.lang.String)
     */
    @Override
    public User importLDAPUserByScreenName(long companyId, String screenName) throws Exception {
        return super.importLDAPUserByScreenName(companyId, screenName);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#setLDAPToPortalConverter(com.liferay.portal.security.ldap.
     * LDAPToPortalConverter)
     */
    @Override
    public void setLDAPToPortalConverter(LDAPToPortalConverter ldapToPortalConverter) {
        super.setLDAPToPortalConverter(ldapToPortalConverter);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#addUser(long, com.liferay.portal.security.ldap.LDAPUser,
     * java.lang.String)
     */
    @Override
    protected User addUser(long companyId, LDAPUser ldapUser, String password) throws Exception {

        ldapUser = preProcessLdapUser(ldapUser);
        return super.addUser(companyId, ldapUser, password);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#updateUser(long, com.liferay.portal.security.ldap.LDAPUser,
     * com.liferay.portal.model.User, java.lang.String, java.lang.String)
     */
    @Override
    protected User updateUser(long companyId, LDAPUser ldapUser, User user, Properties userMappings, Properties contactMappings, String password, String modifiedDate, boolean isNew) throws Exception {

        ldapUser = preProcessLdapUser(ldapUser);
        return super.updateUser(companyId, ldapUser, user,userMappings,contactMappings, password, modifiedDate, isNew);
    }

    /**
     * Pre-process the given {@link LDAPUser} before it allowing it to be passed on to Liferay's storage.
     *
     * @param ldapUser The user to process.
     * @return Processed user.
     */
    private LDAPUser preProcessLdapUser(LDAPUser ldapUser) {

        if (ldapUser == null) {
            return ldapUser;
        }

        String jobTitle = ldapUser.getJobTitle();
        if (jobTitle != null && jobTitle.length() > MAX_JOB_TITLE_LENGTH) {
            jobTitle = jobTitle.substring(0, 100);
            ldapUser.setJobTitle(jobTitle);
        }

        return ldapUser;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.liferay.portal.security.ldap.PortalLDAPImporterImpl#importFromLDAPByUser(long, long, javax.naming.ldap.LdapContext,
     * java.util.Properties, java.util.Properties, java.util.Properties, java.util.Properties, java.util.Properties)
     */
    @Override
    protected void importFromLDAPByUser(
            long ldapServerId, long companyId, LdapContext ldapContext,
            Properties userMappings, Properties userExpandoMappings,
            Properties contactMappings, Properties contactExpandoMappings,
            Properties groupMappings)
                    throws Exception {

        byte[] cookie = new byte[0];

        while (cookie != null) {
            List<SearchResult> searchResults = new ArrayList<SearchResult>();

            String userMappingsScreenName = GetterUtil.getString(
                    userMappings.getProperty("screenName")).toLowerCase();

            cookie = PortalLDAPUtil.getUsers(
                    ldapServerId, companyId, ldapContext, cookie, 0,
                    new String[] {userMappingsScreenName}, searchResults);

            for (SearchResult searchResult : searchResults) {
                try {
                    Attributes userAttributes =
                            PortalLDAPUtil.getUserAttributes(
                                    ldapServerId, companyId, ldapContext,
                                    PortalLDAPUtil.getNameInNamespace(
                                            ldapServerId, companyId, searchResult));

                    User user = importUser(
                            ldapServerId,companyId, userAttributes, userMappings,
                            userExpandoMappings, contactMappings,
                            contactExpandoMappings, StringPool.BLANK);

                    importGroups(
                            ldapServerId, companyId, ldapContext, userAttributes,
                            user, userMappings, groupMappings);
                } catch (Exception e) {

                    if (e instanceof DuplicateUserEmailAddressException) {
                        log.info("Duplicate e-mail at user " + searchResult);
                    } else if (e instanceof UserEmailAddressException) {
                        log.info("Incorrect or missing e-mail at user " + searchResult);
                    } else if (e instanceof UserScreenNameException) {
                        log.info("Incorrect or missing screen name at user " + searchResult);
                    } else {
                        log.error("Unable to import user " + searchResult, e);
                    }
                }
            }
        }
    }
}