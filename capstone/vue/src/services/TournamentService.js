import axios from "axios";

const http = axios.create({
    baseURL: 'http://localhost:9000'
});

export default {
    getTournaments() {
        return http.get('/tournaments');
    },
    getTournamentDetails(id) {
        return http.get('/tournaments/' + id);
    }
}