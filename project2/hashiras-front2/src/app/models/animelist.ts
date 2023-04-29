export class Animelist {
    id: number;
    image: any;
    title: string;
    score: number;
    trailer: any;
    year: number;
    season: String;
    constructor(id: number, image: any, title: string, score: number, trailer: any, year: number, season: String) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.score = score;
        this.trailer = trailer;
        this.year = year;
        this.season = season;
    }
}
