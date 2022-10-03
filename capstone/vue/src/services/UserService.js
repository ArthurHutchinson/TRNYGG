import axios from "axios";

export default {
    getUserId(username) {
        return axios.get(`/users/${username}/id`)
    },
    getUserById(id) {
        return axios.get(`/user/${id}`)
    },
    getUserDTOByUsername(username) {
        return axios.get(`/userDTO/${username}`)
    }
}