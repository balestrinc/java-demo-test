import angular from 'angular';
import appModule from '../app.module';
import appConfig from '../app.config';


var $ctrl;

class ListClientCtrl {

  constructor($http) {
    $ctrl = this;
    this._$http = $http;
    this.getAllClients();
  }

  noClients() {
    return (!this.error && !$ctrl.isLoading && $ctrl.clients.length < 1);
  }

  getAllClients() {
    $ctrl.error = null;
    $ctrl.isLoading = true;
    this._$http.get(appConfig.apiUrl + '/client')
    .then(
      function(response) {
        $ctrl.clients = response.data;
        $ctrl.isLoading = false;
      }
    ).catch( function(err) {
        $ctrl.error = "Error retrieving the clients";
        $ctrl.isLoading = false;
    });
  }
}

ListClientCtrl.$inject = ['$http'];

export default appModule.controller('ListClientCtrl', ListClientCtrl);