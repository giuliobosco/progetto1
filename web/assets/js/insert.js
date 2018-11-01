$(document).ready(function () {

	let nameValidator = new NameValidator(0,50);
	let emailValidator = new EmailValidator(4, 256);

	let firstname = false;
	let lastname = false;
	let street = false;
	let streetNumber = false;
	let city = false;
	let nap = false;
	let email = false;
	let number = false;
	let gender = false;

	function toggleSubmit() {
		if (firstname === true &&
			lastname === true &&
			street === true &&
			streetNumber === true &&
			city === true &&
			nap === true &&
			email === true &&
			number === true &&
			gender === true) {
			$("input[type='submit']").attr('enabled');
		} else {
			$("input[type='submit']").attr('disabled');
		}
	}

	toggleSubmit();

	$( "input[name='name']" ).keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			firstname = true;
		} else {
			$(this).css('border-color', '#f00');
			firstname = false;
		}

		toggleSubmit();
	});

	$("input[name='surname']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			lastname = true;
		} else {
			$(this).css('border-color', '#f00');
			lastname = false;
		}

		toggleSubmit();
	});

	$("input[name='street']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			street = true;
		} else {
			$(this).css('border-color', '#f00');
			street = false;
		}

		toggleSubmit();
	});

	$("input[name='streetNumber']").keyup(function () {
		if (LocalValidator.civicNumber($(this).val())) {
			$(this).css('border-color', '#000');
			streetNumber = true;
		} else {
			$(this).css('border-color', '#f00');
			streetNumber = false;
		}

		toggleSubmit();
	});

	$("input[name='city']").keyup(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			city = true;
		} else {
			$(this).css('border-color', '#f00');
			city = false;
		}

		toggleSubmit();
	});

	$("input[name='nap']").keyup(function () {
		if (LocalValidator.nap($(this).val())) {
			$(this).css('border-color', '#000');
			nap = true;
		} else {
			$(this).css('border-color', '#f00');
			nap = false;
		}

		toggleSubmit();
	});

	$("input[name='email']").keyup(function () {
		if (emailValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			email = true;
		} else {
			$(this).css('border-color', '#f00');
			email = false;
		}

		toggleSubmit();
	});

	$("input[name='number']").keyup(function () {
		if (LocalValidator.phone($(this).val())) {
			$(this).css('border-color', '#000');
			number = true;
		} else {
			$(this).css('border-color', '#f00');
			number = false;
		}

		toggleSubmit();
	});

	$("input[name='gender']").keyup(function () {
		if (LocalValidator.gender($(this).val())) {
			$(this).css('border-color', '#000');
			gender = true;
		} else {
			$(this).css('border-color', '#f00');
			gender = false;
		}

		toggleSubmit();
	});
});