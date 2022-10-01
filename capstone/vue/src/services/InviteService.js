import axios from "axios";

export default {
    createInvite(invite){
        return axios.post('/create/invite', invite)
    },

    pendingInvites(){
        return axios.get('invites/')
    }
}