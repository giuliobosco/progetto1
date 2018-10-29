$(document).ready(function () {

	let nameValidator = new NameValidator(0,50);
	let localValidators = new LocalValidator(0, 50);
	let emailValidator = new EmailValidator(5, 256);

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

	$( "input[name='name']" ).keydown(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			firstname = true;
		} else {
			$(this).css('border-color', '#f00');
			firstname = false;
		}

		toggleSubmit();
	});

	$("input[name='surname']").keydown(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			lastname = true;
		} else {
			$(this).css('border-color', '#f00');
			lastname = false;
		}

		toggleSubmit();
	});

	$("input[name='street']").keydown(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			street = true;
		} else {
			$(this).css('border-color', '#f00');
			street = false;
		}

		toggleSubmit();
	});

	$("input[name='streetNumber']").keydown(function () {
		if (localValidators.civicNumber($(this).val())) {
			$(this).css('border-color', '#000');
			streetNumber = true;
		} else {
			$(this).css('border-color', '#f00');
			streetNumber = false;
		}

		toggleSubmit();
	});

	$("input[name='city']").keydown(function () {
		if (nameValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			city = true;
		} else {
			$(this).css('border-color', '#f00');
			city = false;
		}

		toggleSubmit();
	});

	$("input[name='nap']").keydown(function () {
		if (localValidators.nap($(this).val())) {
			$(this).css('border-color', '#000');
			nap = true;
		} else {
			$(this).css('border-color', '#f00');
			nap = false;
		}

		toggleSubmit();
	});

	$("input[name='email']").keydown(function () {
		if (emailValidator.isValid($(this).val())) {
			$(this).css('border-color', '#000');
			email = true;
		} else {
			$(this).css('border-color', '#f00');
			email = false;
		}

		toggleSubmit();
	});

	$("input[name='number']").keydown(function () {
		if (localValidators.phone($(this).val())) {
			$(this).css('border-color', '#000');
			number = true;
		} else {
			$(this).css('border-color', '#f00');
			number = false;
		}

		toggleSubmit();
	});

	$("input[name='gender']").keydown(function () {
		if (localValidators.gender($(this).val())) {
			$(this).css('border-color', '#000');
			gender = true;
		} else {
			$(this).css('border-color', '#f00');
			gender = false;
		}

		toggleSubmit();
	});
});