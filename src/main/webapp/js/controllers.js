'use strict';

/* Controllers */
function GenericViewCtrl($scope, $http) {}

function PricePlanDialogController($scope, dialog, $http){
    $http.get('rest/priceplans').success(function(data){
        $scope.pricePlans = data;
    });

    $scope.cancel = function(){
        dialog.close();
    };
    $scope.open = function(result){
        dialog.close(result);
    };
}

function TestCtrl($scope, $http) {
    $scope.rate = function() {
        var request = {};
        request.pricePlanCode = $scope.pricePlanCode;
        request.ratingCode = $scope.ratingCode;
        request.amount = parseInt($scope.amount);
        request.destination = $scope.destination;
        request.chargeDate = $scope.datetime;
        $http.post('rest/rates', request).success(function(data) {
            $scope.locations = data.locations;
            $scope.charges = data.chargeLines;
        });
    }
}

function PricePlanCtrl($scope, $http, $dialog) {
    $scope.disabled = "disabled";
    $scope.alerts = [];

    $scope.foldJS = function(cm, where) {
        cm.foldCode(where, CodeMirror.braceRangeFinder);
    }

    $scope.createPricePlan = function() {
        var data = JSON.parse($scope.json);
        $http.post('rest/priceplans', data).success(function() {
            $scope.alerts.push({type: 'success', msg: "Price plan updated successfully."});
        }).error(function() {
                $scope.alerts.push({type: 'error', msg: "Price plan update error."});
            });
    };

    $scope.openDialog = function(){
        var d = $dialog.dialog({
            templateUrl: 'partials/openPricePlan.html',
            controller: 'PricePlanDialogController'
        });
        d.open().then(function(result){
            if(result) {
                $http.get('rest/priceplans/'+result[0].code).success(function(data){
                    $scope.json = JSON.stringify(data, null, 2);
                    $scope.disabled = "";
                });
            }
        });
    };

    $scope.closeAlert = function(index) {
        $scope.alerts.splice(index, 1);
    };

}



