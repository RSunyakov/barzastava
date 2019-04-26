var express = require('express');
var router = express.Router();
var fs = require('fs');

/* GET users listing. */
router.get('/', function(req, res, next) {
    fs.readFile('orders.txt', 'utf-8', function (err, data) {
        var dataByString = data.split('\n');
        var result = [];
        for (var i = 0; i < dataByString.length - 1; i++) {
            var elems = dataByString[i].split(' ');
            result.push({
                'item_id': elems[0],
                'firstnameo': elems[1],
                'secondnameo': elems[2]
            })
        }
        res.json(result);
    })
});

module.exports = router;
