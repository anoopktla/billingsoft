app.service('itemService', [ '$http', function($http) {

    this.getItem = function getItem(itemId) {
        return $http({
            method : 'GET',
            url : 'item/' + itemId
        });
    }
} ]);

this.addItem = function addItem(name, description) {
    return $http({
        method : 'POST',
        url : 'item',
        data : {
            name : name,
            description: description
        }
    });
this.getAllItems = function getAllItems() {
    return $http({
        method : 'GET',
        url : 'item'
    });
app.controller('ItemController', ['$scope','itemService',
  function ($scope,itemService) {
      $scope.getItem = function () {
          var id = $scope.item.id;
          itemService.getItem($scope.item.id)
            .then(function success(response) {
                $scope.item = response.data;
                $scope.item.id = id;
                $scope.description='';
                $scope.errorMessage = '';
            },
            function error (response) {
                $scope.message = '';
                if (response.status === 404){
                    $scope.errorMessage = 'User not found!';
                }
                else {
                    $scope.errorMessage = "Error getting user!";
                }
            });
      };
}]);

$scope.addItem = function () {
    if ($scope.item != null && $scope.item.name) {
        itemService.addItem($scope.item.name, $scope.item.description)
          .then (function success(response){
              $scope.message = 'Item added!';
              $scope.errorMessage = '';
          },
          function error(response){
              $scope.errorMessage = 'Error adding item!';
              $scope.message = '';
        });
    }
    else {
        $scope.errorMessage = 'Please enter a name!';
        $scope.message = '';
    }

    $scope.getAllItems = function () {
        itemService.getAllItems()
          .then(function success(response) {
              $scope.items = response.data._embedded.items;
              $scope.message='';
              $scope.errorMessage = '';
          },
          function error (response) {
              $scope.message='';
              $scope.errorMessage = 'Error getting users!';
          });
    }


