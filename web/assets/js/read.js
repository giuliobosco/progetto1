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

function toggleHid(obj) {
	$(obj).children('.card-head').children('span').children('i').toggleClass('fa-angle-down fa-angle-up');
	$(obj).children('.hid').slideToggle();
}

let app = angular.module('ReadApp',[]);

app.controller('LastCtrl', ['$scope', '$http', function ($scope, $http) {
	$http.get('assets/data/last.jsp')
		.then(function (response) {

			let data = response.data;

			$scope.lastSubs = data;
		});
}]);

app.controller('TodayCtrl', ['$scope', '$http', function ($scope, $http) {
	$http.get('assets/data/today.jsp')
		.then(function (response) {
			let data = response.data;

			$scope.todaySubs = data;
		})
}]);

app.controller('AllCtrl', ['$scope', '$http', function ($scope, $http) {
	$http.get('assets/data/all.jsp')
		.then(function (response) {
			let data = response.data;

			$scope.allSubs = data;
		})
}]);