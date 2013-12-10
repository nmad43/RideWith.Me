angular.module('ridewithme', ['ngRoute']);

angular.module('ridewithme').config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'assets/partials/index.html',
            controller: 'IndexCtrl'
        })
        .when('/signup', {
            templateUrl: 'assets/partials/signup.html',
            controller: 'SignupCtrl'
        })
        .when('/login', {
            templateUrl: 'assets/partials/login.html',
            controller: 'LoginCtrl'
        })
        .when('/dashboard', {
            templateUrl: 'assets/partials/dashboard.html',
            controller: 'DashboardCtrl'
        })
        .when('/create', {
            templateUrl: 'assets/partials/create.html',
            controller: 'CreateCtrl'
        })
        .when('/view/:carpoolId', {
            templateUrl: 'assets/partials/view.html',
            controller: 'ViewCtrl'
        })
        .when('/settings', {
            templateUrl: 'assets/partials/settings.html',
            controller: 'SettingsCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);

angular.module('ridewithme').run(['$rootScope', '$location', '$http', function($rootScope, $location, $http) {
	$rootScope.activePage = '';
	$rootScope.loggedIn = {status: false, user: ''};
	$rootScope.carpools = [];
	$rootScope.users = {};
	
	$rootScope.logout = function() {
		$rootScope.loggedIn.status = false;
		$rootScope.loggedIn.user = '';
		$location.path('/');
	};
	
	$http.get('http://localhost:8888/ridewith_me').success(function(data) {
		$rootScope.carpools = data.carpools;
		$rootScope.users = data.users;
	});
}]);

angular.module('ridewithme').filter('limitObjectTo', function() {
	return function(obj, limit) {
		var newObj = {}, i = 0, p;
		for (p in obj) {
			newObj[p] = obj[p];
			if (++i === limit) break;
		}
		return newObj;
	};
});

angular.module('ridewithme').controller('IndexCtrl', ['$rootScope', '$scope', function($rootScope, $scope) {
	$rootScope.activePage = 'index';
	$scope.loggedIn = $rootScope.loggedIn;
}]);

angular.module('ridewithme').controller('SignupCtrl', ['$rootScope', '$scope', '$location', function($rootScope, $scope, $location) {
	$rootScope.activePage = 'signup';
	$scope.doSignup = function() {
		if (angular.isDefined($rootScope.users[$scope.signup.email])) {
			$scope.error = 'Email address is already in use. Please try a different one.'
		}
		else {
			$rootScope.users[$scope.signup.email] = angular.copy($scope.signup);
			$scope.error = false;
			$rootScope.loggedIn.status = true;
			$rootScope.loggedIn.user = $scope.signup.email;
			$scope.signup = {fname: '', lname: '', email: '', password: ''}
			$location.path('dashboard');			
		}
	};
}]);

angular.module('ridewithme').controller('LoginCtrl', ['$rootScope', '$scope', '$location', function($rootScope, $scope, $location) {
	$rootScope.activePage = 'login';
	$scope.doLogin = function() {
		if (angular.isDefined($rootScope.users[$scope.login.email]) && $rootScope.users[$scope.login.email].password === $scope.login.password) {
			// success
			$scope.error = false;
			$rootScope.loggedIn.status = true;
			$rootScope.loggedIn.user = $scope.login.email;
			$scope.login = {email: '', password: ''};
			$location.path('dashboard');
		}
		else {
			// failure
			$scope.login.password = '';
			$scope.error = 'Incorrect email address or password. Please try again.'
		}
	};
}]);

angular.module('ridewithme').controller('DashboardCtrl', ['$rootScope', '$scope', function($rootScope, $scope) {
	$rootScope.activePage = 'dashboard';
}]);

angular.module('ridewithme').controller('CreateCtrl', ['$rootScope', '$scope', '$location', function($rootScope, $scope, $location) {
	$rootScope.activePage = 'create';
	$scope.newCarpool = {destination: '', date: '', time: '', description: '', riders: {}};
	$scope.limit = 5;
	$scope.doCreate = function() {
		$rootScope.carpools.push(angular.copy($scope.newCarpool));
		$scope.newCarpool = {destination: '', date: '', time: '', description: '', riders: {}};
		$location.path('dashboard');
	};
	$scope.getUsers = function() {
		var results = {};
		angular.forEach($rootScope.users, function(value, key) {
			if (!angular.isDefined($scope.newCarpool.riders[key])) {
				results[key] = value;
			}
		});
		return results;
	};
	$scope.addRider = function(key) {
		$scope.newCarpool.riders[key] = {email: key, amountOwed: 0, paid: true};
	};
	$scope.removeRider = function(key) {
		delete $scope.newCarpool.riders[key];
	};
}]);

angular.module('ridewithme').controller('ViewCtrl', ['$rootScope', '$scope', '$routeParams', '$http', function($rootScope, $scope, $routeParams, $http) {
	$rootScope.activePage = 'view';
	$scope.current = $rootScope.carpools[$routeParams.carpoolId];
	var waypoints = [];
	var directionsDisplay = new google.maps.DirectionsRenderer();
	var fiu = new google.maps.LatLng(25.758658, -80.37617);
	var mapOptions = {
		zoom: 7,
		center: fiu
	}
	var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	directionsDisplay.setMap(map);
	
	for (var i = 0; i < $scope.current.riders.length; i++) {
		waypoints.push({
			location: $rootScope.users[$scope.current.riders[i].email].address.line1 + ', ' + $rootScope.users[$scope.current.riders[i].email].address.line2,
			stopover: false
		});
	}
	
	var directionsService = new google.maps.DirectionsService();
	directionsService.route({
		origin: '11200 SW 8th St, Miami, FL 33174',
		destination: $scope.current.destination.address.line1 + ', ' + $scope.current.destination.address.line2,
		travelMode: google.maps.TravelMode.DRIVING,
		waypoints: waypoints,
		optimizeWaypoints: true,
		provideRouteAlternatives: false
	}, function(result, status) {
		console.log(result, status);
		if (status == google.maps.DirectionsStatus.OK) {
			directionsDisplay.setDirections(result);
		}
	});
}]);

angular.module('ridewithme').controller('SettingsCtrl', ['$rootScope', '$scope', function($rootScope, $scope) {
	$rootScope.activePage = 'settings';
}]);