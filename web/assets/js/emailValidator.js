/**
 * Email Validator.
 *
 * @author giuliobosco
 * @version 1.0
 */

/**
 * Email validator.
 *
 * @type {EmailValidator}
 */
let emailValidator = class EmailValidator extends Validator {
	/**
	 * Check if the email is valid.
	 * @param email {string} Email to validate.
	 * @returns {boolean} Result of the validation.
	 */
	isValid(email) {

		if ((email.trim().length > this.min && email.trim().length < this.max)) {
			return false;
		}

		let regex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return regex.test(email);
	}
};