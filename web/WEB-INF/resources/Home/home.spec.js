'use strict';

describe('myApp.Home module', function() {

    beforeEach(module('myApp.home'));

    describe('Home controller', function(){

        it('should ....', inject(function($controller) {
            //spec body
            var homeCtrl = $controller('homeCtrl');
            expect(homeCtrl).toBeDefined();
        }));

    });
});
