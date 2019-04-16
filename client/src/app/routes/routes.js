require('../list-client/list-client');
require('../create-client/create-client');

routes.$inject = ['$routeProvider', '$locationProvider'];

export default function routes($routeProvider, $locationProvider) {
  $locationProvider.html5Mode(true);
  $routeProvider
    .when('/', {
      template: require('../list-client/list-client.html'),
      controller: 'ListClientCtrl',
      controllerAs: 'list'
    })
    .when('/newclient', {
      template: require('../create-client/create-client.html'),
      controller: 'CreateClientCtrl',
      controllerAs: 'createCli'
    });

}