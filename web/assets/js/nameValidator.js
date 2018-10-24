/**
 * Name Validator.
 *
 * @author giuliobosco
 * @verision 1.1
 */

/**
 * Name Validator.
 * @type {NameValidator}
 */
let nameValidator = class NameValidator extends Validator {
	/**
	 * Validate email.
	 *
	 * @param name {string} Name to validate.
	 * @returns {boolean} Result of the validation.
	 */
	isValid(name) {
		if (!(name.trim().length > this.min && name.trim().length < this.max)) {
			return false;
		}

		let regex = /^[a-zA-Z\u00C0-\u00ff]+$/;
		return regex.test(name);
	}
};