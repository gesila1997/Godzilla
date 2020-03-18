import axios from '@/utils/request'

export const getDemoListPage = (query) => {
  return axios.request({
    url: '/StudentList',
    data: query,
    method: 'post'
  })
};

// export const getPsumselect = (query) => {
//   return axios.request({
//     url: '/Psumselect',
//     data: query,
//     method: 'post'
//   })
// };

// export const getUserNameList = (query) => {
//   return axios.request({
//     url: '',
//     data: query,
//     method: 'post'
//   })
// };

export const saveOrUpdateDemo = (parameter) => {
  return axios.request({
    url: '/updateStudent',
    method: 'put',
    params : parameter
  })
};

export const deleteDemo = (parameter) => {
  return axios.request({
    url: '/delStudent',
    method: 'delete',
    params: {
      id: parameter
    }
  })
};