function openCity(evt, cityName) {
	let i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tabcontent");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tablinks");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(cityName).style.display = "block";
	evt.currentTarget.className += " active";
}

let app = angular.module('ReadApp',[]);

app.controller('LastController', ['$scope', '$http', function ($scope, $http) {
	$http.get('assets/data/last.json')
		.then(function (response) {

			let data = response.data;

			$scope.lastSubs = data;
			console.log(data);
		});
}]);