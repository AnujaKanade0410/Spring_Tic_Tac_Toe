var ticTacToe = angular.module('ticTacToe', ['ngRoute','gameModule']);




ticTacToe.config(['$routeProvider', function($routeProvider) {
    $routeProvider.
        when('/game/:id', {
            templateUrl: 'templates/game-board.html',
            controller: 'gameController'
        }).
        when('/player/panel', {
            templateUrl: 'templates/player-panel.html',
            controller: 'newGameController'
        }).
        otherwise({
            redirectTo: '/player/panel'
        });
}]);
