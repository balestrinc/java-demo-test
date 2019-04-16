import angular from 'angular';
import appModule from '../app.module'
import appConfig from '../app.config';

var $ctrl;

class CreateClientCtrl {

  constructor($http) {
    $ctrl = this;
    this._$http = $http;
    this.reset();
  }

  reset(form) {
    this.client = {
      risk: 'A'
    }
    if (form) {
      form.$setPristine();
      form.$setUntouched();
    }
  }

  create(form) {

    if(!form.$valid){
      return;
    }

    $ctrl.isSaving = true;
    $ctrl.error = null;
    $ctrl.newClient =  null;
    this._$http.post(appConfig.apiUrl + '/client', this.client)
    .then(
      function(response) {
        $ctrl.newClient = response.data;
        $ctrl.isSaving = false;
      }
    ).catch( function(err) {
        $ctrl.error = "Error creating the client";
        $ctrl.isSaving = false;
    });
  }
}

CreateClientCtrl.$inject = ['$http'];

export default appModule.controller('CreateClientCtrl', CreateClientCtrl);
