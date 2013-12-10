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

angular.module('ridewithme').controller('CreateCtrl', ['$rootScope', '$scope', function($rootScope, $scope) {
	$rootScope.activePage = 'create';
	$scope.doCreate = function() {
		$rootScope.carpools.push(angular.copy($scope.newCarpool));
		$scope.newCarpool = {destination: '', date: '', description: '', riders: []};
	}
}]);

angular.module('ridewithme').controller('ViewCtrl', ['$rootScope', '$scope', '$routeParams', function($rootScope, $scope, $routeParams) {
	$rootScope.activePage = 'view';
	$scope.current = $rootScope.carpools[$routeParams.carpoolId];
}]);

angular.module('ridewithme').controller('SettingsCtrl', ['$rootScope', '$scope', function($rootScope, $scope) {
	$rootScope.activePage = 'settings';
}]);