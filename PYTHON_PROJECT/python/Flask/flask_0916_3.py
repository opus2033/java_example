from flask import Flask, jsonify
app = Flask(__name__)

@app.route('/server_info')
def hello_json():
    data = {'server_name' : '0.0.0.0', 'server_port' : '5000'}
    return jsonify(data)

if __name__ == "__main__":              
    app.run(host="0.0.0.0", port="5000")