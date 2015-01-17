-- IN PSQL:
-- \i E:/OneDrive/Workspaces/java_new/nsai_struts2_impl/src/main/resources/postgres_init_data.sql

BEGIN;

DO $$DECLARE 
	admin_role_id integer;
	user_role_id integer;
    admin_user_id integer;
BEGIN
    INSERT INTO security_roles values (default, 'ROLE_ADMIN') RETURNING ID INTO admin_role_id;
	INSERT INTO security_roles values (default, 'ROLE_USER') RETURNING ID INTO user_role_id;

	--INSERT ADMIN USER
	INSERT INTO users (ID, EMAIL, FIRSTNAME, LASTNAME, LOGIN, PASSWORDENCRYPTED) 
	VALUES (default, 'admin@admin.pl', 'admin', 'admin', 'admin', '$2a$10$e2KSFCEQMvyH1YWilmrfJuJ66NXiCVX3dLRyXndevyuYW0EAK/JfC')
	RETURNING ID INTO admin_user_id;

	--INSERT ADMIN ROLES
	INSERT INTO users_security_roles VALUES (admin_user_id, admin_role_id);
	INSERT INTO users_security_roles VALUES (admin_user_id, user_role_id);
END$$;

COMMIT;