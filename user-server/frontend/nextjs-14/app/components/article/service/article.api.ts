import { instance } from "@/app/components/common/configs/axios-config"

export const findAllArticlesAPI = async (page:number) =>{
    try {

        const response = await instance.get('/articles/list',{
            params: {page,limit: 10}
        })
        return response.data
        
    } catch (error) {
        console.log(error)
        return error
        
    }
}
export const findArticlesByIdAPI = async (id:number) =>{
    try {

        const response = await instance.get('/articles/detail',{
            params: {id,limit: 10}
        })
        return response.data
        
    } catch (error) {
        console.log(error)
        return error
        
    }
}
export const DeleteArticleByIdAPI = async (id:number) =>{
    try {

        const response = await instance.delete('/articles/delete',{
            params: {id,limit: 10}
        })
        return response.data
        
    } catch (error) {
        console.log(error)
        return error
        
    }
}
export const UpdateArticleByIdAPI = async (id:number) =>{
    try {

        const response = await instance.get('/articles/modifiy',{
            params: {id,limit: 10}
        })
        return response.data
        
    } catch (error) {
        console.log(error)
        return error
        
    }
}
