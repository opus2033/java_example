var express = require('express');
var router = express.Router();

//   MySQL 로드
var pool = require('./mysqlConn');

router.get('/', function(req, res, next) {
    res.redirect('/board2/list');
});

router.get('/list', function(req,res,next){
    pool.getConnection(function (err, connection) {
        var sql = "SELECT NUM, TITLE, WRITER, MEMO, DATE_FORMAT(DATE,'%Y-%m-%d') DATE" +
                   " FROM test";
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);
//            console.log("rows : " + JSON.stringify(rows));

            res.render('board2/list', {rows: rows});
            connection.release();
        });
    }); 
});

router.get('/read', function(req,res,next){
    pool.getConnection(function (err, connection) {
        var sql = "SELECT NUM, TITLE, WRITER, MEMO, DATE_FORMAT(DATE,'%Y-%m-%d') DATE" +
                  " FROM test"; +
                  " WHERE NUM=" + req.query.NUM;
            console.log("rows : " + sql);
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);
            console.log("rows : " + JSON.stringify(rows));

            res.render('board2/read', {row: rows[0]});
            connection.release();
        });
    }); 
});

router.get('/form', function(req,res,next){
    if (!req.query.NUM) {
        res.render('board2/form', {row: ""});
        return;
    }
    pool.getConnection(function (err, connection) {
        var sql = "SELECT NUM, TITLE, WRITER, MEMO, DATE_FORMAT(DATE,'%Y-%m-%d') DATE" +
                  " FROM test"; +
                  " WHERE NUM=" + req.query.NUM;
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);

            res.render('board2/form', {row: rows[0]});
            connection.release();
        });
    }); 
});

router.post('/save', function(req,res,next){
    var data = [req.body.title, req.body.memo, req.body.writer, req.body.num];
console.log("rows : " + data);

    pool.getConnection(function (err, connection) {
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

            res.redirect('/board2/list');
            connection.release();
        });
    }); 
});

router.get('/delete', function(req,res,next){
    pool.getConnection(function (err, connection) {
        var sql = "DELETE FROM test" +
                  " WHERE NUM=" + req.query.NUM;
        connection.query(sql, function (err, rows) {
            if (err) console.error("err : " + err);

            res.redirect('/board2/list');
            connection.release();
        });
    }); 
});

module.exports = router;