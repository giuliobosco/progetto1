/**
 * Local Validator.
 * Validate:
 * <ul>
 *     <li>gender</li>
 *     <li>phone number</li>
 *     <li>nap</li>
 *     <li>birth date</li>
 *     <li>civic number</li>
 * </ul>
 *
 * @author giuliobosco
 * @version 1.3
 */
class LocalValidator extends Validator {

	/**
	 * Validate the gender.
	 *
	 * @param gender {string} Gender to validate.
	 * @returns {boolean} Result of the validation.
	 */
	static gender(gender) {
		if (gender.toLowerCase() == "m" || gender.toLowerCase() == "f") {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate the phone number.
	 *
	 * @param phone {string} Number to validate.
	 * @returns {boolean} Result of the validation.
	 */
	static phone(phone) {
		let regex = /^\d+$/;
		if (phone.trim().length > 8 && phone.trim().length < 13 && regex.test(phone)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate the NAP number.
	 *
	 * @param nap {string} NAP to validate.
	 * @returns {boolean} Result of the validation.
	 */
	static nap(nap) {
		if (nap.trim().length > 3 && nap.trim().length < 6) {
			if (/^\d{4,5}$/.test(nap)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validate the Birth Date number.
	 *
	 * @param birthDate {string} Birth Date to validate.
	 * @returns {boolean} Result of the validation.
	 */
	static birthDate(birthDate) {
		let regex = /^\d{2}([./-])\d{2}\1\d{4}$/;

		return regex.test(birthDate);
	}

	/**
	 * Validate the civic number number.
	 *
	 * @param civicNumber {string} Civic Number to validate.
	 * @returns {boolean} Result of the validation.
	 */
	static civicNumber(civicNumber) {
		let regex = /^[A-z0-9]+$/;
		return regex.test(civicNumber);
	}
}