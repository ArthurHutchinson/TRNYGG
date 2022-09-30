import axios from "axios";

export default {
    getUserId(username) {
        return axios.get(`/users/${username}/id`)
    }
}