
export class List {
    id: number;
    anime_id: number;   //mal_id
    title: string;
    user_id: number;   //user_id
    //user: Users;
    user_rating: number; //user_rating
    status: String;     //status
    image: any;
    // year: number;
    // season: String;
    score: number;
    trailer: any;
    constructor(id: number, anime_id: number, user_id: number, title: string, image: any, user_rating: number, score: number, trailer: any, status: String) {
        this.id = id;
        this.anime_id = anime_id;
        this.user_id = user_id;
        this.title = title;
        this.image = image;
        this.user_rating = user_rating;
        this.score = score;
        this.trailer = trailer;
        this.status = status;
    }
}
