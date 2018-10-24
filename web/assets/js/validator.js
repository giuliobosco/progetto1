/**
 * General validator.
 *
 * @author giuliobosco
 * @version 1.0
 */

/**
 * Main Validator.
 *
 * @type {Validator}
 */
let validator = class Validator {
	/**
	 * Constructor with minimum and maximum length.
	 *
	 * @param min {number} Minimum length.
	 * @param max {number} Maximum length.
	 */
	constructor(min, max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * Check if the value is valid.
	 *
	 * @param string String to check.
	 * @returns {boolean} Result of the validation.
	 */
	isValid(string) {
		if (string.trim().length > this.min && string.trim().length < this.max) {
			return true;
		} else {
			return false;
		}
	}
};