(function () {
    'use strict';

    angular.module('Services.avaliacao', [])
            .service('avaliacaoService', function ($http, api) {
                var $this = this;

                $this.save = function (obj) {
                    return $http.post(api.url + "/avaliacao", obj);
                };
            });


})();
