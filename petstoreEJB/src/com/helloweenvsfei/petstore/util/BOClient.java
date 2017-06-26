package com.helloweenvsfei.petstore.util;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.helloweenvsfei.petstore.entity.CartEO;
import com.helloweenvsfei.petstore.entity.CategoryEO;
import com.helloweenvsfei.petstore.entity.PetEO;
import com.helloweenvsfei.petstore.entity.UserEO;
import com.helloweenvsfei.petstore.session.ICart;
import com.helloweenvsfei.petstore.session.ICategory;
import com.helloweenvsfei.petstore.session.IPet;
import com.helloweenvsfei.petstore.session.IUser;

public class BOClient {

	private static Context context;

	private static Context loadContext() throws NamingException {

		if (context != null)
			return context;

		synchronized (new Integer(1)) {

			if (context != null)
				return context;

			Hashtable<String, String> props = new Hashtable<String, String>();

			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");

			props.put(Context.URL_PKG_PREFIXES,
					"org.jboss.naming:org.jnp.interfaces");

			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");

			context = new InitialContext(props);

		}

		return context;
	}

	public static Object lookup(String name) throws NamingException {
		return loadContext().lookup(name);
	}

	@SuppressWarnings("unchecked")
	public static ICategory<CategoryEO> lookupICategory()
			throws NamingException {
		return (ICategory<CategoryEO>) lookup("CategoryImpl/remote");
	}

	@SuppressWarnings("unchecked")
	public static IPet<PetEO> lookupIPet() throws NamingException {
		return (IPet<PetEO>) lookup("PetImpl/remote");
	}

	@SuppressWarnings("unchecked")
	public static ICart<CartEO> lookupICart() throws NamingException {
		return (ICart<CartEO>) lookup("CartImpl/remote");
	}

	@SuppressWarnings("unchecked")
	public static IUser<UserEO> lookupIUser() throws NamingException {
		return (IUser<UserEO>) lookup("UserImpl/remote");
	}

}
