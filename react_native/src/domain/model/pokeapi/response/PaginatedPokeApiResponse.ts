export default interface PaginatedPokeApiResponse<T> {
    count: number
    next: string
    previous: any
    results: T[]
}