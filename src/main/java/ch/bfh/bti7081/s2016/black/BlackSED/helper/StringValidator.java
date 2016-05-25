package main.java.ch.bfh.bti7081.s2016.black.BlackSED.helper;


import java.util.function.Predicate;

import com.vaadin.data.validator.AbstractValidator;


/** */
@SuppressWarnings("serial")
public final class StringValidator extends AbstractValidator<String>
{
	/** */
	private final Predicate<String> k_xPredicate;

	/** */
	public StringValidator(final Predicate<String> xPredicate)
	{
		this("", xPredicate);
	}

	/** */
	public StringValidator(final String strError, final Predicate<String> xPredicate)
	{
		super(strError);
		k_xPredicate = xPredicate;
	}

	@Override
	public boolean isValidValue(final String strValue)
	{
		return k_xPredicate.test(strValue);
	}

	@Override
	public Class<String> getType()
	{
		return String.class;
	}
}
