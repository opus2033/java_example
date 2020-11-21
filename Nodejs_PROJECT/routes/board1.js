var express = require('express');
var router = express.Router();
var connection = require('./mysqlConn');



router.get('/', function(req, res, next) {
    res.redirect('/board1/list');
});



// router.get('/list', function(req,res,next){
//     Connection(function (err, connection) {
//         var query = "SELECT NUM, TITLE, WRITER, DATE_FORMAT(DATE,'%Y-%m-%d') DATE" +
//                    " FROM test";
//         connection.query(query, function (err, rows) {
//             if (err) console.error("err : " + err);
// //            console.log("rows : " + JSON.stringify(rows));

//             res.render('board1/list', {rows: rows?rows:{}});
//             connection.release();
//         });
//     }); 
// });

router.get('/list', function(req,res,next){
    connection.query( "SELECT NUM, TITLE, WRITER, DATE_FORMAT(DATE,'%Y-%m-%d') DATE FROM test" , function (err, rows, fields) {
        if (!err) {
            console.log(rows);
            res.render('board1/list', {rows: rows?rows:{}});
            // var rows = JSON.stringify(rows)
            // res.render('board1/list', {rows});
        } else {
            console.log('query error : ' + err);
            res.send(err);
            connection.end();
        }
    });
});







// router.get('/read', function(req,res,next){
//     pool.getConnection(function (err, connection) {
//         var sql = "SELECT BRDNO, BRDTITLE, BRDMEMO, BRDWRITER, DATE_FORMAT(BRDDATE,'%Y-%m-%d') BRDDATE"+
//                    " FROM TBL_BOARD" +
//                   " WHERE BRDNO=" + req.query.brdno;
//             console.log("rows : " + sql);
//         connection.query(sql, function (err, rows) {
//             if (err) console.error("err : " + err);
//             console.log("rows : " + JSON.stringify(rows));

//             res.render('board1/read', {row: rows[0]});
//             connection.release();
//         });
//     }); 
// });




router.get('/read', function(req,res,next){
    Connection.query("SELECT NUM, TITLE, MEMO, WRITER, DATE_FORMAT(DATE,'%Y-%m-%d') DATE FROM test WHERE NUM=" + req.query.NUM , function (err, connection) {
        //     console.log("rows : " + sql);
        // connection.query(sql, function (err, rows) {
        //     if (err) console.error("err : " + err);
        //     console.log("rows : " + JSON.stringify(rows));
            res.render('board1/read', {row: rows[0]});
            connection.release();
        });
    }); 
// });

router.get('/form', function(req,res,next){
    if (!req.query.NUM) {
        res.render('board1/form', {row: ""});
        return;
    }
    Connection(function (err, connection) {
        var sql = "SELECT NUM, TITLE, MEMO, WRITER, DATE_FORMAT(DATE,'%Y-%m-%d') DATE" + 
                   " FROM test" +
                  " WHERE NUM=" + req.query.NUM;
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);

            res.render('board1/form', {row: rows[0]});
            connection.release();
        });
    }); 
});

router.post('/save', function(req,res,next){
    var data = [req.body.title, req.body.memo, req.body.writer, req.body.num];
console.log("rows : " + data);

    Connection(function (err, connection) {
        var sql = "";
        if (req.body.NUM) {
            sql = "UPDATE test" +
                       " SET TITLE=?, MEMO=?, WRITER=?" +
                  " WHERE NUM=?";
        } else {
            sql = "INSERT INTO test(TITLE, MEMO, WRITER, DATE) VALUES(?,?,?, NOW())";
        }
        connection.query(sql, data, function (err, rows) {
            if (err) console.error("err : " + err);

            res.redirect('/board1/list');
            connection.release();
        });
    }); 
});

router.get('/delete', function(req,res,next){
    Connection(function (err, connection) {
        var sql = "DELETE FROM test" +
                  " WHERE NUM=" + req.query.NUM;
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);

            res.redirect('/board1/list');
            connection.release();
        });
    }); 
});

module.exports = router;
