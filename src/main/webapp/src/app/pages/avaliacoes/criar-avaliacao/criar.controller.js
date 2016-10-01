(function () {
  'use strict';

  angular.module('BlurAdmin.pages.avaliacao.criar.controller', [])
      .controller('criarController', criarController);

  /** @ngInject */
  function criarController(repeticaoService, avaliacaoService) {
      this.repeticaoService = repeticaoService;
      this.avaliacaoService=avaliacaoService;
      
      var $this = this;
      
      $this.repeticaoService.getRepeticao().then(function(response){
          console.log("repeteco ", response);
          $this.repeticoes = response.data;
      },function (){
          console.error("Falha ao recuperar as repetições")
      });
      
    console.log("Deu certo mlk!");
  }
  
//    criarController.prototype.salvar = function (obj){
//        var $this = this;
//        obj['usuarioCriador'] = {id : 1};
//        console.log(obj);
//        var sucesso = function (){ console.log("salvou")};
//        var falha = function (){ console.log("falha")};
//        
//        $this.avaliacaoService.save(obj).then(sucesso, falha);
//    };

})();
