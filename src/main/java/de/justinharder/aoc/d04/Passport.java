package de.justinharder.aoc.d04;

import java.util.Objects;

public class Passport
{
	private Field birthYear;
	private Field issueYear;
	private Field expirationYear;
	private Field height;
	private Field hairColor;
	private Field eyeColor;
	private Field passportId;
	private Field countryId;

	public Passport() {}

	public Field getBirthYear()
	{
		return birthYear;
	}

	public Field getIssueYear()
	{
		return issueYear;
	}

	public Field getExpirationYear()
	{
		return expirationYear;
	}

	public Field getHeight()
	{
		return height;
	}

	public Field getHairColor()
	{
		return hairColor;
	}

	public Field getEyeColor()
	{
		return eyeColor;
	}

	public Field getPassportId()
	{
		return passportId;
	}

	public Passport setBirthYear(String birthYear)
	{
		if (birthYear != null)
		{
			this.birthYear = new Field(PassportKeys.BIRTH_YEAR, birthYear);
		}
		return this;
	}

	public Passport setIssueYear(String issueYear)
	{
		if (issueYear != null)
		{
			this.issueYear = new Field(PassportKeys.ISSUE_YEAR, issueYear);
		}
		return this;
	}

	public Passport setExpirationYear(String expirationYear)
	{
		if (expirationYear != null)
		{
			this.expirationYear = new Field(PassportKeys.EXPIRATION_YEAR, expirationYear);
		}
		return this;
	}

	public Passport setHeight(String height)
	{
		if (height != null)
		{
			this.height = new Field(PassportKeys.HEIGHT, height);
		}
		return this;
	}

	public Passport setHairColor(String hairColor)
	{
		if (hairColor != null)
		{
			this.hairColor = new Field(PassportKeys.HAIR_COLOR, hairColor);
		}
		return this;
	}

	public Passport setEyeColor(String eyeColor)
	{
		if (eyeColor != null)
		{
			this.eyeColor = new Field(PassportKeys.EYE_COLOR, eyeColor);
		}
		return this;
	}

	public Passport setPassportId(String passportId)
	{
		if (passportId != null)
		{
			this.passportId = new Field(PassportKeys.PASSPORT_ID, passportId);
		}
		return this;
	}

	public Passport setCountryId(String countryId)
	{
		if (countryId != null)
		{
			this.countryId = new Field(PassportKeys.COUNTRY_ID, countryId);
		}
		return this;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Passport passport = (Passport) o;
		return Objects.equals(birthYear, passport.birthYear) && Objects.equals(issueYear, passport.issueYear) && Objects
			.equals(expirationYear, passport.expirationYear) && Objects.equals(height, passport.height) && Objects
			.equals(hairColor, passport.hairColor) && Objects.equals(eyeColor, passport.eyeColor) && Objects
			.equals(passportId, passport.passportId) && Objects.equals(countryId, passport.countryId);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId, countryId);
	}

	@Override
	public String toString()
	{
		return "Passport{birthYear=" + birthYear +
			", issueYear=" + issueYear +
			", expirationYear=" + expirationYear +
			", height=" + height +
			", hairColor=" + hairColor +
			", eyeColor=" + eyeColor +
			", passportId=" + passportId +
			", countryId=" + countryId + "}";
	}

	public static class Builder
	{
		private String birthYear;
		private String issueYear;
		private String expirationYear;
		private String height;
		private String hairColor;
		private String eyeColor;
		private String passportId;
		private String countryId;

		private Builder birthYear(String birthYear)
		{
			this.birthYear = birthYear;
			return this;
		}

		private Builder issueYear(String issueYear)
		{
			this.issueYear = issueYear;
			return this;
		}

		private Builder expirationYear(String expirationYear)
		{
			this.expirationYear = expirationYear;
			return this;
		}

		private Builder height(String height)
		{
			this.height = height;
			return this;
		}

		private Builder hairColor(String hairColor)
		{
			this.hairColor = hairColor;
			return this;
		}

		private Builder eyeColor(String eyeColor)
		{
			this.eyeColor = eyeColor;
			return this;
		}

		private Builder passportId(String passportId)
		{
			this.passportId = passportId;
			return this;
		}

		private Builder countryId(String countryId)
		{
			this.countryId = countryId;
			return this;
		}

		public Builder with(Field field)
		{
			var passportKey = field.getKey();
			if (passportKey.equals(PassportKeys.BIRTH_YEAR))
			{
				return birthYear(field.getValue());
			}
			if (passportKey.equals(PassportKeys.ISSUE_YEAR))
			{
				return issueYear(field.getValue());
			}
			if (passportKey.equals(PassportKeys.EXPIRATION_YEAR))
			{
				return expirationYear(field.getValue());
			}
			if (passportKey.equals(PassportKeys.HEIGHT))
			{
				return height(field.getValue());
			}
			if (passportKey.equals(PassportKeys.HAIR_COLOR))
			{
				return hairColor(field.getValue());
			}
			if (passportKey.equals(PassportKeys.EYE_COLOR))
			{
				return eyeColor(field.getValue());
			}
			if (passportKey.equals(PassportKeys.PASSPORT_ID))
			{
				return passportId(field.getValue());
			}
			return countryId(field.getValue());
		}

		public Passport build()
		{
			return new Passport()
				.setBirthYear(birthYear)
				.setIssueYear(issueYear)
				.setExpirationYear(expirationYear)
				.setHeight(height)
				.setHairColor(hairColor)
				.setEyeColor(eyeColor)
				.setPassportId(passportId)
				.setCountryId(countryId);
		}
	}
}
