from datetime import datetime 

from flask import Flask
from flask_restx import Resource, Api
from module.auth import Auth
from module.get_instance import GCEInstance


# app = Flask(__name__)
# createData = MakeData()
 
# @app.route('/sites/current/',methods=['POST'])
# def current(site_id): 
#     request.form['accessCode'] = 'DEV'
#     site_id = request.form['site_id']
#     return jsonify(createData.getData(site_id)), 200

# @app.route('/sites/latest/<site_id>',methods=['GET'])
# def latest(site_id):
#     return jsonify(createData.getLatestData(site_id)), 200

# if __name__ == '__main__':
#     app.config['JSON_AS_ASCII'] = False
#     app.run(debug=True, host='0.0.0.0')

app = Flask(__name__)
api = Api(
    app,
    version='0.1',
    title="JustKode's API Server",
    description="JustKode's Todo API Server!",
    terms_url="/",
    contact="jaypark@mz.co.kr",
    # license="MIT"
)

api.add_namespace(Auth, '/auth')
api.add_namespace(GCEInstance, '/instances')

if __name__ == "__main__":
    app.config['JSON_AS_ASCII'] = False
    app.run(debug=True, host='0.0.0.0', port=80)