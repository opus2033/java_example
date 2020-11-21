
from googleapiclient.discovery import build
from oauth2client.service_account import ServiceAccountCredentials
from flask_restx import Resource, Namespace, fields
from flask import request

import os
import json
import pprint



GCEInstance = Namespace(
    name="GCEInstance",
    description="GCE Instance",
)

# instance_name = GCEInstance.model('Instance Name', {  # Model 객체 생성
#     'instance_name': fields.String(description='Instance name', required=True, example="gce_instance_name")
#     'specs': fields.
# })

def getServiceAccountServiceBuild(  key_file_location
                                    ,   api_name
                                    ,   api_version
                                    ,   scopes=list()): 
        credentials = ServiceAccountCredentials.from_json_keyfile_name(
                key_file_location, scopes=scopes)

        # Build the service object.
        service = build(api_name, api_version, credentials=credentials)

        return service
def list_instances( compute, project, zone):
        result = compute.instances().aggregatedList(project=project, zone=zone).execute()
        
        with open(os.path.abspath('./data.json'), 'w') as outfile:
            json.dump(result['items'], outfile)

        return json.dumps(result['items'],indent=4) if 'items' in result else None

@GCEInstance.route('/get')
class GCEInstanceGet(Resource):
    @GCEInstance.doc(responses={200: 'Success'})
    
    def post(self):
        compute = getServiceAccountServiceBuild(os.path.abspath('./keyfile/gce-engine-sa.json'),'compute', 'v1',[])
        project = request.json['project']
        # result = compute.instances().aggregatedList(project=project, zone=zone).execute()
        result = compute.instances().aggregatedList(project=project).execute()
        with open(os.path.abspath('./data.json'), 'w') as outfile:
            json.dump(result['items'], outfile)
        # json.dump(result['items']) if 'items' in result else None
        return json.dumps(result['items'],indent=4) if 'items' in result else None