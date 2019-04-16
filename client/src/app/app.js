import angular from 'angular';
import uirouter from 'angular-route';
import routes from './routes/routes';
import appModule from './app.module'

import '../style/app.css';

let app = () => {
  return {
    template: require('./app.html'),
    controller: 'AppCtrl',
    controllerAs: 'app'
  }
};

class AppCtrl {
  constructor() {
    this.url = 'http://www.srmasset.com/';
  }
}

const MODULE_NAME = 'app';

appModule
  .directive('app', app)
  .controller('AppCtrl', AppCtrl)
  .config(routes);

export default MODULE_NAME;