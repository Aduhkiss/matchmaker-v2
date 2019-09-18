package me.atticuszambrana.matchmaker.util;

import java.util.Collection;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;

public class RoleUtil {
	public static boolean hasRole(User user, Server server, String roleName) {
		Collection<Role> allRoles = user.getRoles(server);
		for(Role r : allRoles) {
			if(r.getName().equalsIgnoreCase(roleName)) {
				return true;
			}
		}
		return false;
	}
}
