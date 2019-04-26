var express = require('express');
var router = express.Router();
var fs = require('fs');
var firstnametmp = "";
var secondnametmp = "";

router.get('/', function(req, res, next) {
    fs.readFile('item_list.txt', 'utf-8', function (err, data) {
        var dataByString = data.split('\n');
        var result = [];
        for (var i = 0; i < dataByString.length - 1; i++) {
            var elems = dataByString[i].split(' ');
            result.push({
                'id_items': elems[0],
            'name': elems[1],
            'price': elems[2]
        })
    }
    res.json(result);
    });
    fs.readFile('users.txt', 'utf-8', function (err, data) {
        var dataByString = data.split('\n');
        var elems = dataByString[dataByString.length - 2].split(' ');
        firstnametmp = elems[0];
        secondnametmp = elems[1];
    });
});
router.post('/', function(req, res, next) {
        var item_id = req.body.id_item;
       fs.appendFile('orders.txt', item_id + ' ' + firstnametmp + ' ' + secondnametmp + '\n', function (err) {
           if(err) {
               console.log()
           }
       });
       res.redirect('item_list.html')
});

module.exports = router;