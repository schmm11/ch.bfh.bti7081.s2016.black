package main.java.ch.bfh.bti7081.s2016.black.BlackSED.model;


import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import main.java.ch.bfh.bti7081.s2016.black.BlackSED.db.entities.Person;


/** */
public final class LoginModel
{
	/** */
	private final List<Person> k_lstPeople;

	/** */
	public LoginModel(final List<Person> lstPeople)
	{
		if(lstPeople == null) throw new IllegalArgumentException("lstPeople must not be null");
		if(lstPeople.size() == 0)
		{
			final Person xDefaultUser = new Person();
			xDefaultUser.setUsername("user");
			xDefaultUser.setPassword("black");
			lstPeople.add(xDefaultUser);
		}

		k_lstPeople = new LinkedList<Person>();
		lstPeople.forEach(k_lstPeople::add);
	}

	/** */
	public boolean loginAttempt(final String strUsername, final String strPassword)
	{
		// assume username <-> loginname is unique
		final Optional<Person> xPerson = k_lstPeople.parallelStream()
				.filter(x -> x.getUsername().equals(strUsername))
				.filter(x -> x.getPassword().equals(strPassword))
				.findFirst();
		return xPerson.isPresent();
	}
}
