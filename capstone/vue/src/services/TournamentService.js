import axios from "axios";

// const http = axios.create({
//     baseURL: 'http://localhost:9000'
// });

export default {
    getTournaments() {
        return axios.get('/tournaments');
    },
    getTournamentDetails(id) {
        return axios.get(`/tournaments/${id}`);
    },
    createTournament(tournament) {
        return axios.post('/tournaments/create', tournament);
    },
    getBracketByTournamentId(id) {
        return axios.get(`/tournaments/${id}/bracket`);
    },
    startNewRound(id, players) {
        return axios.post(`/tournaments/${id}/startround`, players);
    },
    getUsersByMatchId(id) {
        return axios.get(`matches/${id}/players`)
    },
    getPlayersByTournamentId(id) {
        return axios.get(`/tournaments/${id}/players`)
    },
    setWinner(id, username) {
        return axios.post(`match/${id}/winner`, username, {headers: {'content-type':'text/json'}})
    }
}
