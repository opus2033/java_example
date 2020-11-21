//   MySQL 로드
var mysql = require('mysql');
var connection = mysql.createConnection({
    host     : '34.64.239.239',
    port     : '3306',
    user     : 'root',
    password : '1234',
    database : 'test'    
});


module.exports = connection;